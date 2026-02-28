// vars/deploy_production.groovy
def call() {
    stage("Deploy") {
        withCredentials([usernamePassword(
            credentialsId: 'dockerHub-jenkinidpass',
            usernameVariable: 'DOCKER_USERNAME',
            passwordVariable: 'DOCKER_PASSWORD'
        )]) {
            sh """
                echo "\$DOCKER_PASSWORD" | docker login -u "\$DOCKER_USERNAME" --password-stdin
                docker compose up -d
            """
        }
    }
}
