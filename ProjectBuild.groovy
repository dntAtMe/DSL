def gitUrl = "https://github.com/dntAtMe/dc"

pipelineJob("DISCORD.VLIFE.master.PIPELINE") {
    concurrentBuild(false)
    description "Builds Discord V-Life project from master branch."
    parameters {
        stringParam('GIT_COMMIT', 'HEAD', 'Commit to build')
    }
    definition {
        cps {
            script(readFileFromWorkspace('pipeline/Jenkinsfile'))
        }
    }
}

job("DISCORD.VLIFE.master.BUILD") {
    scm {
        git {
            branch('master')
            remote {
                url('git@github.com:dntAtMe/BuildsCI.git')
                credentials('dntAtMe2')
            }
            extensions {
                wipeOutWorkspace()
            }
        }
    }
    steps {
        shell('./build-npm.sh')
    }
}
