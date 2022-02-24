package xyz.akaksr.ssh.controller;

import java.io.IOException;
import java.io.InputStream;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xyz.akaksr.ssh.vo.SSHVo;

public class SSHController {
    private final static Logger logger = LoggerFactory.getLogger(SSHController.class);

    private Session session;
    private ChannelExec channelExec;

    public Session connectSSH(SSHVo vo) throws JSchException {
        logger.info("connectSSH 호출");

        session = new JSch().getSession(vo.getUsername(), vo.getHost(), vo.getPort());
        session.setPassword(vo.getPassword());
        session.setConfig("StrictHostKeyChecking", "no");
        session.connect();

        return session;
    }

    // public void exec(Session session, String command) {
    public String exec(Session session, String command) {
        logger.info("exec 호출");

        try {
            channelExec = (ChannelExec) session.openChannel("exec");

            channelExec.setCommand(command);
            InputStream is = channelExec.getInputStream();

            channelExec.connect();

            byte[] buffer = new byte[8192];
            int decodedLength;
            StringBuilder response = new StringBuilder();

            while ((decodedLength = is.read(buffer, 0, buffer.length)) > 0) {
                response.append(new String(buffer, 0, decodedLength));
            }

            // logger.info("결과값 = " + response.toString());

            return response.toString();
        } catch (JSchException e) {
            logger.error("JSchException 발생 = " + e);
            return "SSH 연결 오류 발생";
        } catch (IOException e2) {
            logger.error("IOException 발생 = " + e2);
            return "IO 오류 발생";
        } finally {
            disConnectSSH();
        }
    }

    private void disConnectSSH() {
        if (session != null)
            session.disconnect();
        if (channelExec != null)
            channelExec.disconnect();
    }
}
