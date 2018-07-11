pipeline {
    agent any

    parameters {
        booleanParam(defaultValue: true, description: '', name: 'ON_GRID')
        string(defaultValue: "http://localhost", description: '', name: 'HUB')
        string(defaultValue: "https://mail.google.com/", description: '', name: 'URL')
    }
    
    stages {

        stage ('Execute Selenium') {

            steps {
                  sh 'mvn clean install'
            }
        }
    }
    post {
      success {
            echo  'stop docker'
      }
    }
}
