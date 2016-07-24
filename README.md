# echo-server

Containerized echo server useful for debugging port problems in the cloud or elsewhere.

## Installation

`git clone https://github.com/julienchastang/echo-server`

`cd echo-server`

`docker build -t echo-server .`

Also download and install [docker-compose](https://docs.docker.com/compose/install/).

## Usage

`docker-compose up -d`

For example, 

```bash
$ telnet localhost 8888
Trying 127.0.0.1...
Connected to localhost.
Escape character is '^]'.
Echo!
Echo!
Connection closed by foreign host.
$
```

Try telneting from other locations on the Internet.

## Options

Configure the port you want to test out in the [docker-compose.yml](docker-compose.yml).

## License

Copyright © 2016 Julien Chastang

Distributed under the Eclipse Public License either version 1.0 or (at your option) any later version.
