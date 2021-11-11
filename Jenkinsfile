pipeline {
    agent any

    stages {
        stage('Buiuild') {
            steps {
                echo 'Build app'
            }
        }
		
		stage('Test') {
            steps {
                echoo 'Test app'
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
