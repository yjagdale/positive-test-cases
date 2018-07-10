pipeline {
    agent any

    parameters {
        booleanParam(defaultValue: true, description: '', name: 'ON_GRID')
        string(defaultValue: "http://localhost:4444/wd/hub", description: '', name: 'HUB')
        string(defaultValue: "http://localhost:4444/", description: '', name: 'URL')
    }
    
    stages {
        
        stage ('Deploy docker Image') {
            steps {
                sh 'sudo docker run --rm -ti --name zalenium -p 4444:4444 -v /var/run/docker.sock:/var/run/docker.sock -v /tmp/videos:/home/seluser/videos --privileged dosel/zalenium start'
            }
        }
        
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
      always {
          sh 'sudo docker-compose down'
        }
      success {
            archive "target/**/*"
      }
    }
}
