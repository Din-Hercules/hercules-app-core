package com.hercules.herculesappcore.repositories

import com.hercules.herculesappcore.models.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> {}