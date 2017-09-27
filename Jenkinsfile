#!groovy

//stage 'package'
//node {
//    checkout scm
//    mvn 'clean package'
//}


stage 'Load a file from GitHub'

def helloworld = fileLoader.fromGit('examples/fileLoader/helloworld',
        'https://github.com/jenkinsci/workflow-remote-loader-plugin.git', 'master', null, '')

stage 'Run method from the loaded file'
helloworld.printHello()

input '确定继续吗？'

stage 'test'
node {
    deploy('test')
    testAlive('')
}

input '发布到生产环境？'

stage 'production'
node {
    deploy('prod')
    testAlive('')
}

def mvn(args) {
    sh "${tool 'M3'}/bin/mvn ${args}"
}

def deploy(env) {
    dir('target') {
        sh "mkdir -p envs/$env"
        sh "cp spring-jap-dome.jar envs/$env"
        sh "cd envs/$env"
        sh "nohup java -jar spring-jap-dome.jar > /logs/casefolder-solution/app.log 2>&1 &"
        sh "echo $env"
    }
}

def testAlive(url) {
    sleep 3
}

