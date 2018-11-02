pipeline {
  agent any
  stages {
    stage('start') {
      agent any
      environment {
        file = 'REPOS/${JOB_NAME}/${BUILD_ID}/${BUILD_NUMBER}'
      }
      steps {
        echo 'Start'
      }
    }
    stage('build') {
      agent any
      steps {
        sh 'mvn clean package'
      }
    }
    stage('Art') {
      steps {
        sh '''mkdir Package
cp */target/*.{war,jar} Package'''
      }
    }
    stage('Scp') {
      steps {
        sh 'echo $file'
      }
    }
    stage('zs') {
      parallel {
        stage('zs') {
          steps {
            archiveArtifacts '*/target/*.jar'
          }
        }
        stage('war') {
          steps {
            archiveArtifacts '*/target/*.war'
          }
        }
      }
    }
  }
}