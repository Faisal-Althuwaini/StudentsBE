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
				url: 'https://github.com/Faisal-Althuwaini/CalculatorBE.git'
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
			mail to: 'fynth2@gmail.com, saalemx19@gmail.com, abdullahghomaidah@gmail.com',
            subject: "Zo6: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
            body: "Good news! The build succeeded.\nCheck the build details here: ${env.BUILD_URL}"

		}
		failure {
			echo 'Pipeline failed!'
		}
	}
}