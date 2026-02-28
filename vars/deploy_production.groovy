package com.vivek.cicd   // adjust your package path if needed

class DeployProduction implements Serializable {

    def steps

    DeployProduction(steps) {
        this.steps = steps
    }

    void deploy() {
        steps.stage("Deploy") {
            steps.withCredentials([steps.usernamePassword(
                credentialsId: 'dockerHub-jenkinidpass',
                usernameVariable: 'DOCKER_USERNAME',
                passwordVariable: 'DOCKER_PASSWORD'
            )]) {
                steps.sh """
                    echo "\$DOCKER_PASSWORD" | docker login -u "\$DOCKER_USERNAME" --password-stdin
                    docker compose up -d
                """
            }
        }
    }
}
