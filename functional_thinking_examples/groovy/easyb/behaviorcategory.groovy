static void shouldBe(Object self, value, String msg) {
    isEqual(self, value, msg)
}

private static void isEqual(self, value, String msg) {
    if (self.getClass() == NullObject.class) {
        if (value != null) {
            throwValidationException(
                "expected ${value.toString()} but target object is null", msg)
        }
    } else if (value.getClass() == String.class) {
        if (!value.toString().equals(self.toString())) {
            throwValidationException(
                "expected ${value.toString()} but was ${self.toString()}", msg)
        }
    } else {
        if (value != self) {
            throwValidationException("expected ${value} but was ${self}", msg)
        }
    }
}
