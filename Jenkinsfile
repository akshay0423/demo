pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                echo 'Starting Checkout stage...'
                git url: 'https://github.com/akshay0423/demo', branch: 'main'
                echo 'Checkout stage complete.'
            }
        }

        stage('Build') {
            steps {
                echo 'Starting Build stage...'
                bat 'mvn clean compile'
                echo 'Build stage complete.'
            }
        }

        stage('Test') {
            steps {
                echo 'Starting Test stage...'
                bat 'mvn test'
                echo 'Test stage complete.'
            }
        }

        stage('Deploy to Staging') {
            steps {
                echo 'Starting Deploy to Staging stage...'
                bat 'xcopy /E /I /Y target\\*.* C:\\path\\to\\staging\\'
                echo 'Deploy to Staging complete.'
            }
        }

        stage('Approval to Deploy to Production') {
            steps {
                echo 'Waiting for approval to deploy to production...'
                input message: 'Deploy to Production?', ok: 'Yes, Deploy'
                echo 'Approval received. Deploying to production.'
            }
        }

        stage('Deploy to Production') {
            steps {
                echo 'Starting Deploy to Production stage...'
                bat 'xcopy /E /I /Y target\\*.* C:\\path\\to\\production\\'
                echo 'Deploy to Production complete.'
            }
        }
    }

    post {
    failure {
        echo 'Build failed! Notifying team...'
        
        emailext(
            subject: "Build FAILED: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
            body: """<p>Build <b>${env.JOB_NAME} #${env.BUILD_NUMBER}</b> has <span style='color:red;'>FAILED</span>.</p>
                     <p>Check the console output <a href="${env.BUILD_URL}console">here</a>.</p>""",
            to: 'akshay0423@yahoo.com'
        )
    }
}

