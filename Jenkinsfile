pipeline {
    agent any

    parameters {
        booleanParam(defaultValue: true, description: '', name: 'ON_GRID')
        string(defaultValue: "http://localhost/wd/hub", description: '', name: 'HUB')
        string(defaultValue: "https://mail.google.com/", description: '', name: 'URL')
    }
    
    stages {
        
        stage ('Deploy docker Image') {
            steps {
                sh 'sudo docker run -d --rm -ti --name zalenium -p 80:4444 -v /var/run/docker.sock:/var/run/docker.sock -v /tmp/videos:/home/seluser/videos --privileged dosel/zalenium start'
                sleep 30
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
          sh 'sudo docker stop zalenium'
        }
      success {
            archive "target/**/*"
      }
    }
}
