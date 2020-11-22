package icu.epq.minihr.service;

import icu.epq.minihr.mapper.HrMapper;
import icu.epq.minihr.model.Hr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author EPQ
 * <p>
 * 校验用户登陆信息是否和数据库一致
 */
@Service
public class HrService implements UserDetailsService {

    @Autowired
    HrMapper hrMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Hr hr = hrMapper.loadUserByUsername(username);
        if (hr == null) {
            throw new UsernameNotFoundException("用户不存在！");
        }
        hr.setRoles(hrMapper.getHrRoleById(hr.getId()));
        return hr;
    }
}
