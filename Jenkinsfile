pipeline {
  agent any
  stages {
    stage('start') {
      agent any
      steps {
        echo 'Start'
      }
    }
    stage('build') {
      agent any
      steps {
        git(url: 'https://github.com/jglick/simple-maven-project-with-tests.git', branch: 'master', changelog: true, poll: true)
      }
    }
  }
}