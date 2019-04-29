package cn.mldn.microboot.service.impl;

import org.springframework.stereotype.Service;

import cn.mldn.microboot.service.IMemberService;
import cn.mldn.microboot.vo.Member;
@Service
public class MemberServiceImpl implements IMemberService {

	@Override
	public Member get(String mid) {
		Member vo = new Member();
		vo.setMid(mid);
		vo.setSelary(12222.2);
		return vo;
	}

}
