pipeline {
  agent any
  stages {
    stage('sample') {
      steps {
        cucumber(fileIncludePattern: 'cucumber.json', jsonReportDirectory: 'target/')
      }
    }
  }
}