// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: user_service.proto

package com.sun.lib.grpc.user.service;

public final class UserProto {
  private UserProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\022user_service.proto\022\031com.sun.lib.grpc.u" +
      "ser.dto\032\016user_dto.proto2\254\002\n\004User\022a\n\004list" +
      "\022,.com.sun.lib.grpc.user.dto.SearchUserR" +
      "equest\032\'.com.sun.lib.grpc.user.dto.UserR" +
      "esponse\"\0000\001\022[\n\003add\022).com.sun.lib.grpc.us" +
      "er.dto.AddUserRequest\032\'.com.sun.lib.grpc" +
      ".user.dto.UserResponse\"\000\022d\n\010addBatch\022).c" +
      "om.sun.lib.grpc.user.dto.AddUserRequest\032" +
      "\'.com.sun.lib.grpc.user.dto.UserResponse" +
      "\"\000(\0010\001B,\n\035com.sun.lib.grpc.user.serviceB" +
      "\tUserProtoP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.sun.lib.grpc.user.dto.UserDto.getDescriptor(),
        });
    com.sun.lib.grpc.user.dto.UserDto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
