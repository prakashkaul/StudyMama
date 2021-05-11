import paramiko
import time
import sys


def sshexeccmd(ip, docker_hub_id):
    try:
        ssh = paramiko.SSHClient()
        # add to host_allow
        ssh.set_missing_host_key_policy(paramiko.AutoAddPolicy())
        pkey = paramiko.RSAKey.from_private_key_file('id_rsa')
        ssh.connect(hostname=ip, port=22, username='ubuntu', pkey=pkey)

        docker_compose = ""
        logstash_dockerfile = ""
        logstash_conf = ""
        with open("docker-compose-start.yml", "r") as f:
            docker_compose += f.read()
        with open("logstash/Dockerfile", "r") as f:
            logstash_dockerfile += f.read()
        with open("logstash/conf/logstash.conf", "r") as f:
            logstash_conf += f.read()

        ssh.exec_command('echo "' + docker_compose + '" > docker-compose-start.yml')
        ssh.exec_command('mkdir logstash')
        ssh.exec_command('echo "' + logstash_dockerfile + '" > logstash/Dockerfile')
        ssh.exec_command('mkdir logstash/conf')
        ssh.exec_command('echo "' + logstash_conf + '" > logstash/conf/logstash.conf')
        print("write file done.")
        
        
        ssh.exec_command('sudo docker ps -ls')
        stdin, stdout, stderr = ssh.exec_command('sudo docker ps | grep studymama')
        docker_container_id = stdout.read().decode()
        print(docker_container_id)
        docker_container_id = docker_container_id.split(" ")[0]
        stdin, stdout, stderr =ssh.exec_command('sudo docker stop ' + docker_container_id )
        print('sudo docker stop ' + docker_container_id )
        print(stdout.read().decode())
        print(stderr.read().decode())
        
        stdin, stdout, stderr =ssh.exec_command('sudo docker rm ' + docker_container_id)
        print('sudo docker rm ' + docker_container_id )
        print(stdout.read().decode())
        print(stderr.read().decode())
        
        stdin, stdout, stderr = ssh.exec_command('sudo docker image rm ' + docker_hub_id + '/studymama')
        print('sudo docker image rm liye2949/studymama' )
        print(stdout.read().decode())
        print(stderr.read().decode())
        print("remove old studymama version done.")

        ssh.exec_command('echo y | sudo docker image prune')
        ssh.exec_command('echo y | sudo docker container prune')
        
        ssh.exec_command('screen -S build_and_start')
        print("screen -S build_and_start")
        
        stdin, stdout, stderr = ssh.exec_command('sudo docker-compose -f docker-compose-start.yml up --build -d')
        print("docker-compose -f docker-compose-start.yml up --build -d")
        while not stdout.channel.exit_status_ready():
            result = stdout.readline()
            print(result)

            if stdout.channel.exit_status_ready():
                a = stdout.readlines()
                print(a)
                break
        print("run service done...")
        ssh.close()
    except Exception as e:
        print(e)


if __name__ == '__main__':
    sshexeccmd(sys.argv[1], sys.argv[2])
    print('$' * 100)
