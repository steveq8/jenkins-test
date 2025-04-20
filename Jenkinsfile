pipeline {
    agent any

    tools {
        maven 'Maven-3.9.9'
        jdk 'Java 11'
    }

    environment {
        CHROME_DRIVER_PATH = 'C:\\path\\to\\chromedriver.exe'
        JMETER_PATH = 'C:\\path\\to\\apache-jmeter-5.5\\bin'
    }

    stages {
        stage('Checkout Code') {
            steps {
                git 'https://github.com/youruser/your-repo.git'
            }
        }

        stage('Compile') {
            steps {
                bat 'mvn compile'
            }
        }

        stage('Run Web Tests') {
            steps {
                bat "mvn test"
            }
        }

        stage('Publish Test Report') {
            steps {
                junit '**/target/surefire-reports/*.xml'
                publishHTML([
                    reportDir: 'target/surefire-reports',
                    reportFiles: 'index.html',
                    reportName: 'HTML Test Report',
                    keepAll: true,
                    allowMissing: false,
                    alwaysLinkToLastBuild: true
                ])
            }
        }

        stage('Run Load Test') {
            steps {
                bat "\"${env.JMETER_PATH}\\jmeter.bat\" -n -t load_test.jmx -l result.jtl -e -o jmeter-report"
            }
        }

        stage('Publish Load Test Report') {
            steps {
                publishHTML([
                    reportDir: 'jmeter-report',
                    reportFiles: 'index.html',
                    reportName: 'JMeter Load Test Report',
                    keepAll: true,
                    allowMissing: false,
                    alwaysLinkToLastBuild: true
                ])
            }
        }
    }

    post {
        always {
            echo 'Pipeline Finished'
        }
    }
}
