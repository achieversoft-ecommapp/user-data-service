pipeline {
    agent any
    tools{
        maven 'jenkins-maven'
    }
    stages{
        stage('build customer-data-service'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/release/25.01']], extensions: [],
                            userRemoteConfigs: [[url: 'https://github.com/achieversoft-ecommapp/customer-data-service']]])
                bat 'mvn clean install'
            }
        }
        stage('Build docker image'){
                    steps{
                        script{
                            bat 'docker build -t prsdockerhub/achieversoft .'
                        }
                    }
                }
          stage('Push image to Hub'){
                           steps{
                              script{
                                           bat 'docker login -u "prsdockerhub" -p "Gambhadia@123#" docker.io'
                                           bat 'docker push prsdockerhub/achieversoft:latest'
                                        }
                                    }
                                }
         stage('Deploy to k8s'){
                    steps{
                        script{
                            kubernetesDeploy (configs: 'deployment.yaml',kubeconfigId: 'k8configpwd')
                               }
                           }
                       }





    }
}