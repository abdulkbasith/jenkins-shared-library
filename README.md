# jenkins-shared-library-

## Shared Library

A shared library in Jenkins is a collection of reusable Groovy scripts that can be used in Jenkins pipelines. Shared libraries allow you to encapsulate common functionality into reusable components, which can make your pipelines more concise, maintainable, and reusable.

# Here are some advantages of using a shared library in Jenkins:

    * Code reuse
    * Consistency
    * Centralized management
    * Version control
    * Testing

## Here is an example of how to use a shared library in a Jenkinsfile:

```groovy

//Author: Abdul Basith

@Library('my-shared-library') _

pipeline{
    
    agent any

    environment {
        dockerimagename = "registry.example.com:5000/$build_image" 
    }

    stages{

        stage('Checkout Source'){
            steps{
                gitCheckout(branch: 'branchName', credentialsId: 'CredentialsId', url: 'gitUrl')
            }
        }

        stage('Docker Build'){
            steps{
                script{
                    dockerBuild('${dockerimagename}')
                }
            }
        }

        stage('Image Scan'){
            steps{
                script{
                    trivyScan('${dockerimagename}', '${build_image}')
                }
            }
        }                             

        stage('Docker Push'){
            steps{
                script{
                    dockerPush('${dockerimagename}')
                }
            }
        }   
    }
}
