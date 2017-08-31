pipeline {
  agent any
  stages {
    stage('sample') {
      steps {
        cucumber(fileIncludePattern: 'cucumber.json', jsonReportDirectory: 'target/', buildStatus: 'SUCCESS')
        hygieiaArtifactPublishStep(artifactName: 'x', artifactDirectory: 'y', artifactGroup: 'z', artifactVersion: 'q')
        hygieiaBuildPublishStep(buildStatus: 'SUCCESS')
        hygieiaSonarPublishStep()
        hygieiaCodeQualityPublishStep(checkstyleFilePattern: 'x')
        hygieiaTestPublishStep(buildStatus: 'x', testFileNamePattern: 'y', testResultsDirectory: 'x', testType: 'd', testApplicationName: 'x', testEnvironmentName: 'd')
        logstashSend(failBuild: true, maxLines: 10000)
      }
    }
  }
}