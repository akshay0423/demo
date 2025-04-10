pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                echo 'Starting Checkout stage...'
                git url: 'https://github.com/akshay0423/demo', branch: 'main'
                echo 'Checkout complete.'
            }
        }

        stage('Build') {
            steps {
                echo 'Starting Build stage...'
                bat 'mvn clean compile'
                echo 'Build complete.'
            }
        }

        stage('Test') {
            steps {
                echo 'Starting Test stage...'
                bat 'mvn test'
                echo 'Test complete.'
            }
        }

        stage('Deploy to Staging') {
            steps {
                echo 'Starting Deploy to Staging stage...'
                bat 'xcopy /E /I target\\*.* C:\\path\\to\\staging\\'
                echo 'Deploy to Staging complete.'
            }
        }

        stage('Approval to Deploy to Production') {
            steps {
                echo 'Waiting for approval to deploy to Production...'
                input message: 'Deploy to Production?', ok: 'Yes, Deploy'
                echo 'Approval received. Proceeding to deploy to Production.'
            }
        }

        stage('Deploy to Production') {
            steps {
                echo 'Starting Deploy to Production stage...'
                bat 'xcopy /E /I target\\*.* C:\\path\\to\\production\\'
                echo 'Deploy to Production complete.'
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
