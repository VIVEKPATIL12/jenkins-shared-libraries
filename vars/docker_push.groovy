def call(String projectName, String imageTag = "latest", String credentialsId = "dockerHub-jenkinidpass") {
    withCredentials([usernamePassword(
        credentialsId: credentialsId,
        usernameVariable: 'DOCKER_USERNAME',
        passwordVariable: 'DOCKER_PASSWORD'
    )]) {
        sh """
            echo "\$DOCKER_PASSWORD" | docker login -u "\$DOCKER_USERNAME" --password-stdin
            docker push ${DOCKER_USERNAME}/${projectName}:${imageTag}
            docker push ${DOCKER_USERNAME}/${projectName}:latest
        """
    }
}
