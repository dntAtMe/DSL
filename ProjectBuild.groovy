def gitUrl = "https://github.com/dntAtMe/dc"

job("ProjectBuild") {
    concurrentBuild(false)
    description "Builds dc project from master branch."
    parameters {
        stringParam('GIT_COMMIT', 'HEAD', 'Commit to build')
    }
    definition {
        cps {
            script(readFileFromWorkspace('pipeline/Jenkinsfile'))
        }
    }
}