pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/akshay0423/demo', branch: 'main'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Deploy to Staging') {
            steps {
                bat 'xcopy /E /I target\\*.* C:\\path\\to\\staging\\'
            }
        }

        stage('Approval to Deploy to Production') {
            steps {
                input message: 'Deploy to Production?', ok: 'Yes, Deploy'
            }
        }

        stage('Deploy to Production') {
            steps {
                bat 'xcopy /E /I target\\*.* C:\\path\\to\\production\\'
            }
        }
    }

    post {
        failure {
            echo 'Build failed! Notifying team...'
            // Optionally add email/slack notification
        }
    }
}
