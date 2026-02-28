def call(String ProjentName, String ImageTag, String DockerHubUser) {
    sh "docker build -t ${DockerHubUser}/${ProjentName}:${ImageTag} ."
}
