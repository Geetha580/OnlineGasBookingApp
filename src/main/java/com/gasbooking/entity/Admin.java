package com.gasbooking.entity;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="admin_id")
public class Admin extends AbstractUser implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = -535712062774093171L;
		
		public Admin() {
			super();
		}

		public Admin(String userName, String password, String address, String mobileNumber, String email) {
			super(userName, password, address, mobileNumber, email);
		}

}
