pipeline {
    agent any

    parameters {
        booleanParam(defaultValue: true, description: '', name: 'ON_GRID')
        string(defaultValue: "http://localhost", description: '', name: 'HUB')
        string(defaultValue: "https://mail.google.com/", description: '', name: 'URL')
    }
    
    stages {

        stage ('Build Application') {

            steps {
                    sh 'mvn clean compile'
            }
        }

        stage ('Execute Selenium') {

            steps {
                  sh 'mvn test'
            }
        }
    }
    post {
      success {
            archive "target/**/*"
      }
    }
}
