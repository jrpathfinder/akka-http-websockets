package com.example.core

import scala.collection.immutable.Seq
import akka.actor.ActorRef
import com.example.shared.PublicProtocol

object PrivateProtocol {
  sealed trait Event
  case class Joined(connectId: String, ref: ActorRef) extends Event
  case class Left(connectId: String) extends Event

  case class Role(role : Option[Roles.Role]) extends Event
  case class IdWithInMessage(id: String, message: PublicProtocol.Message) extends Event
  case class RoleByNameRequest(username: String) extends Event

  case class TableEvent(table: Tables.TableBase, users: Seq[String])
  case class TablesEvent(tables: Seq[Tables.TableBase])
}

object Roles {
  sealed trait Role
  object Admin extends Role
  object User extends Role
}