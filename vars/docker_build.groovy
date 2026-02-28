
def call(String projectName, String imageTag = "latest", String dockerUser) {
    sh "docker build -t ${dockerUser}/${projectName}:${imageTag} ."
}
