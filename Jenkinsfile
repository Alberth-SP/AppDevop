pipeline{
    agent any
    environment {
        GIT_REPO_URL = 'https://github.com/Alberth-SP/AppDevop.git'
        GIT_BRANCH = 'main'
        IMAGE_NAME = 'app-devop'
        IMAGE_TAG = 'latest'
        CONTAINER_NAME = 'docker-app-devop'
        
        
    }
    stages {
        stage("Clean Workspace"){
            steps{
                
                script{
                    try{
                        bat "docker stop ${CONTAINER_NAME} || true"}
                    catch(e){
                        
                    }
                    try{
                        bat "docker container rm ${CONTAINER_NAME} || true"}
                    catch(e){
                        
                    }
                    try{
                        bat "docker image rm ${IMAGE_NAME}:${IMAGE_TAG} || true "
                    }
                    catch(e){
                        
                    }
                    deleteDir()
                }
            }
        }
        stage("Clone Repository"){
            steps {
                script {
                    git branch: "${GIT_BRANCH}", url: "${GIT_REPO_URL}"
                    
                }
            }
        }
        stage("Build"){
            steps {
                script{
                    bat "mvnw clean package"
                }
            }
        }
        
        stage("Build Docker Image"){
            steps {
                script {
                    bat "docker build -t ${IMAGE_NAME}:${IMAGE_TAG} ."
                }
            }
            
        }
        stage("Test"){
            steps{
                script {
                    bat "dir target"
                }
            }
        }
        stage("Docker Run container"){
            steps{
                script{
                    bat "docker run -d -p 8090:8090 --name ${CONTAINER_NAME} ${IMAGE_NAME}:${IMAGE_TAG}"
                }
            }
            
        }
    }
}