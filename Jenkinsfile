pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "saratha/spring-boot-rest-api"
        DOCKER_USER = "docker_username"
        
        
    }

    stages {
                stage('Checkout') {
            steps {
                // Checkout the code from the version control system
                git url:'https://github.com/SarathaNatraj/SpringBootRestAPI.git', branch:'main'
            }
        }
        
        stage('Build') {
            steps {
                script {
                    // Clean and build the Spring Boot application
                    bat 'mvn clean install'
                }
            }
        }

        stage('Check Docker') {
            steps {
                script {
                    // Check if Docker is installed
                    try {
                        bat 'docker --version'
                        echo 'Docker is installed.'
                    } catch (Exception e) {
                        error 'Docker is not installed or not properly configured.'
                    }
                }
            }
        }


        stage('Build Docker Image') {
            steps {
                script {
                    // Build the Docker image
                bat "docker build -t ${DOCKER_IMAGE}:latest ."
                //  bat "docker-compose down"
                  bat "docker-compose build"
                //   bat "docker-compose down"
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                script {
                    // Login to Docker Hub or your private registry
                    
                    // Tag and push the Docker image
                    bat "docker tag ${DOCKER_IMAGE} ${DOCKER_IMAGE}:latest"
                   bat "docker login -u ${DOCKER_USER} -p "
                   
                    bat "docker push ${DOCKER_IMAGE}:latest"
                  //  bat "docker push ${DOCKER_IMAGE}"
                }
            }
        }

        
    }

    post {
        always {
            // Clean up after the build
            bat 'docker system prune -f'
        }
    }
}
