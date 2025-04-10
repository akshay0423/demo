pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out the code...'
                git url: 'https://github.com/akshay0423/demo', branch: 'main'
            }
        }

        stage('Build') {
            steps {
                echo 'Building the project...'
                bat 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                echo 'Running unit tests...'
                bat 'mvn test'
            }
        }

        stage('Deploy to Staging') {
            steps {
                echo 'Deploying to staging environment...'
                bat 'xcopy /E /I /Y target\\*.* C:\\path\\to\\staging\\'
                echo 'Running app in staging...'
                bat 'java -jar C:\\path\\to\\staging\\calculator-1.0-SNAPSHOT.jar'
            }
        }

        stage('Approval to Deploy to Production') {
            steps {
                input message: 'Deploy to Production?', ok: 'Yes, Deploy'
            }
        }

        stage('Deploy to Production') {
            steps {
                echo 'Deploying to production environment...'
                bat 'xcopy /E /I /Y target\\*.* C:\\path\\to\\production\\'
                echo 'Running app in production...'
                bat 'java -jar C:\\path\\to\\production\\calculator-1.0-SNAPSHOT.jar'
            }
        }
    }

    post {
        failure {
            echo 'Build failed! Notifying team...'
            // Add Slack or email notification if needed
        }
    }
}
