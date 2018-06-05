create table if not exists resume
(
  uuid      char(36) not null constraint resume_pkey primary key,
  full_name text     not null
);

create table if not exists contact
(
  id          serial   not null constraint contact_pkey primary key,
  resume_uuid char(36) not null constraint contact_resume_uuid_fk references resume on delete cascade,
  type        text     not null,
  value       text     not null
);

CREATE UNIQUE INDEX contact_uuid_type_index
  ON public.contact (resume_uuid, type);


