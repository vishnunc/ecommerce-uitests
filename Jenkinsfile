pipeline {
  agent any
  stages {
    stage('sample') {
      steps {
        logstashSend(failBuild: true, maxLines: 10000)
      }
    }
  }
}