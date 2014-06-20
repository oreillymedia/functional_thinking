package com.nealford.funtionalthinking.trans;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Process {

    // BEGIN java8_process
    public String cleanNames(List<String> names) {
        if (names == null) return "";
        return names
                .stream()
                .filter(name -> name.length() > 1)
                .map(name -> capitalize(name))
                .collect(Collectors.joining(","));
    }

    private String capitalize(String e) {
        return e.substring(0, 1).toUpperCase() + e.substring(1, e.length());
    }
// END java8_process


    // BEGIN java8_process_parallel
    public String cleanNamesP(List<String> names) {
        if (names == null) return "";
        return names
                .parallelStream()
                .filter(n -> n.length() > 1)
                .map(e -> capitalize(e))
                .collect(Collectors.joining(","));
    }
// END java8_process_parallel

}
