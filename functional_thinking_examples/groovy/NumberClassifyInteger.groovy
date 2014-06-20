Integer.metaClass.isPerfect = {->
  Classifier.isPerfect(delegate)
}

Integer.metaClass.isAbundant = {->
  Classifier.isAbundant(delegate)
}

Integer.metaClass.isDeficient = {->
  Classifier.isDeficient(delegate)
}
