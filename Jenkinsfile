pipeline {
    agent any
    tools{
        maven 'jenkins-maven'
    }
    stages{
        stage('build parent-pom'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/release/25.01']], extensions: [],
                            userRemoteConfigs: [[url: 'https://github.com/achieversoft-ecommapp/parent-pom']]])
                bat 'mvn clean install'
            }
        }
		stage('build common-app-library'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/release/25.01']], extensions: [],
                            userRemoteConfigs: [[url: 'https://github.com/achieversoft-ecommapp/common-app-library']]])
                bat 'mvn clean install'
            }
        }
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
         stage('Deploy db to k8s'){
                    steps{
                        script{
                            kubernetesDeploy (configs: 'mysql-deployment.yaml',kubeconfigId: 'k8configpwd')
                               }
                           }
                       }

        stage('Deploy app to k8s'){
                            steps{
                                script{
                                    kubernetesDeploy (configs: 'deployment.yaml',kubeconfigId: 'k8configpwd')
                                       }
                                   }
                               }





    }
}