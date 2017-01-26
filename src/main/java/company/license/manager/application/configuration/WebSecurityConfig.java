package company.license.manager.application.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{    
	public final String USERS_BY_USERNAME_QUERY = "SELECT login, password, enabled FROM lm_user WHERE login = ?";
	public final String AUTHORITIES_BY_USERNAME_QUERY = "SELECT lm_user.login, lm_userauthority.authority"
			+ " FROM lm_user, lm_userauthority WHERE lm_user.userid = lm_userauthority.userid AND lm_user.login = ?";
	public final String GROUP_AUTHORITIES_BY_USERNAME_QUERY = "SELECT lm_group.groupid, lm_group.groupname, lm_groupauthority.groupauthority"
			+ " FROM lm_group, lm_groupauthority, lm_groupmembership, lm_user WHERE lm_user.login = ? AND lm_user.userid = lm_groupmembership.userid AND lm_groupmembership.groupid = lm_groupauthority.groupid";
	
	@Autowired
	DataSource dataSource;
	
	@Override
    protected void configure(HttpSecurity http) throws Exception
	{
        http
            .authorizeRequests()
                .anyRequest().authenticated()
            .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
            .and()
            .logout()
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
    {
        auth
        	.jdbcAuthentication()
            .dataSource(dataSource)
        	.usersByUsernameQuery(USERS_BY_USERNAME_QUERY)
        	.authoritiesByUsernameQuery(AUTHORITIES_BY_USERNAME_QUERY)
        	.groupAuthoritiesByUsername(GROUP_AUTHORITIES_BY_USERNAME_QUERY);
    }
}