pipeline {
	agent any

	tools {
		maven 'M3'
		jdk 'JDK21'
	}

	stages {
		stage('Checkout') {
			steps {
				git branch: 'master',
				url: 'https://github.com/Faisal-Althuwaini/StudentsBE.git'
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
			post {
				always {
					junit 'target/surefire-reports/*.xml'
				}
			}
		}

		stage('Package') {
			steps {
				bat 'mvn package -DskipTests'
			}
		}
	}

	post {
		always {
			cleanWs()
		}
		success {
			echo 'Pipeline completed successfully! Test2    '
			mail to: 'fynth2@gmail.com',
            subject: "SUCCESS: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
            body: "Good news! The build succeeded.\nCheck the build details here: ${env.BUILD_URL}"

		}
		failure {
			echo 'Pipeline failed!'
						mail to: 'fynth2@gmail.com',
                        subject: "FAILURE: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
                        body: "Bad news! The build failed.\nCheck the build details here: ${env.BUILD_URL}"

		}
	}
}