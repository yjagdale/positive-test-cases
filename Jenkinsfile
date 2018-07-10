pipeline {
    agent any

    stages {
        stage ('Build Application') {

            steps {
                withMaven(maven : 'maven_3_5_0') {
                    sh 'mvn clean compile'
                }
            }
        }

        stage ('Execute Selenium') {

            steps {
                withMaven(maven : 'maven_3_5_0') {
                    sh 'mvn test'
                }
            }
        }


        stage ('Cluster Start') {

            steps {
                withMaven(maven : 'maven_3_5_0') {
                    sh 'mvn fabric8:cluster-start'
                }
            }
        }

         stage ('Deploy docker Image') {

                    steps {
                        withMaven(maven : 'maven_3_5_0') {
                            sh 'docker run -d --rm -ti --name zalenium -p 4444:4444 -v /var/run/docker.sock:/var/run/docker.sock -v /tmp/videos:/home/seluser/videos --privileged dosel/zalenium start'
                        }
                    }
                }
    }
    post {
      always {
        junit "target/surefire-reports/**.xml"
      }
      success {
            archive "target/**/*"
      }
    }
}