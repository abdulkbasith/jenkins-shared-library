def call(String imageName, String reportFile) {
    sh "trivy image --format template --template \"/usr/local/share/trivy/templates/html.tpl\" -o /var/log/${reportFile}.html ${imageName}"
}
