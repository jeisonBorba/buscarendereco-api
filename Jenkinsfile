pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Build app'
            }
        }
		
		stage('Test') {
            steps {
                echo 'Test app'
            }
        }
		
		stage('Deploy') {
            steps {
                echo 'Deploy app'
            }
        }
    }
	
	post {
		success {
			echo 'Pipeline has finished successfully'
		}
	
		failure {
			error 'The pipeline has failed'
		}
	}
}
