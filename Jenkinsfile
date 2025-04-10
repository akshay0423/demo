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
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Deploy to Staging') {
            steps {
                sh 'cp -r target/ ~/staging/'
            }
        }

        stage('Approval to Deploy to Production') {
            steps {
                input message: 'Deploy to Production?', ok: 'Yes, Deploy'
            }
        }

        stage('Deploy to Production') {
            steps {
                sh 'cp -r target/ ~/production/'
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
