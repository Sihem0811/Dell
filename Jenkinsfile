pipeline {
    agent any

    tools {
        maven 'maven'
    }

    environment {
        CUCUMBER_JSON = 'target/cucumber.json'
        CUCUMBER_HTML = 'target/cucumber-report.html'
        ALLURE_RESULTS = 'target/allure-results' // ajouté pour Allure
    }

    stages {
        stage('Checkout') {
            steps {
                checkout([$class: 'GitSCM',
                    branches: [[name: '*/main']],
                    userRemoteConfigs: [[url: 'https://github.com/Sihem0811/Dell.git']]
                ])
            }
        }

        stage('Install Dependencies') {
            steps {
                sh 'mvn clean install -U -DskipTests'
            }
        }

        stage('Run Cucumber Tests') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Archive Reports') {
            steps {
                archiveArtifacts artifacts: "${CUCUMBER_JSON}, ${CUCUMBER_HTML}", allowEmptyArchive: false
            }
        }
    } // ← fin du bloc stages

    post {
        always {
            script {
                if (fileExists(CUCUMBER_JSON)) {
                    cucumber fileIncludePattern: CUCUMBER_JSON
                } else {
                    echo "Cucumber report JSON not found."
                }
            }
            // Publish JUnit test result reports
            junit 'target/surefire-reports/**/*.xml'

            // Publish Allure report
            allure includeProperties: false, jdk: '', results: [[path: "${ALLURE_RESULTS}"]]
        }
    }
}
