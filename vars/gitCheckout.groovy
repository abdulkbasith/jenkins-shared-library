def call(Map params) {
  script {
    def branch = params.branch ?: ''
    def credentialsId = params.credentialsId ?: ''
    def url = params.url ?: ''

    if (!url) {
      error('Git repository URL not provided')
    }

    if (!credentialsId) {
      error('Git credentials ID not provided')
    }

    git branch: branch, credentialsId: credentialsId, url: url
  }
}
