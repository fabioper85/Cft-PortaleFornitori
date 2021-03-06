USE [DB_FORNITORI]
GO
/****** Object:  Table [dbo].[vw_body_rental_vendor]    Script Date: 08/05/2018 16:42:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[vw_body_rental_vendor](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[address] [varchar](255) NULL,
	[address_2] [varchar](255) NULL,
	[blocked_qualification] [int] NULL,
	[city] [varchar](255) NULL,
	[company] [varchar](255) NULL,
	[company_name_no] [varchar](255) NULL,
	[email] [varchar](255) NULL,
	[fax_no] [varchar](255) NULL,
	[name] [varchar](255) NULL,
	[name_2] [varchar](255) NULL,
	[phone_no] [varchar](255) NULL,
	[post_code] [varchar](255) NULL,
	[qualification_notes] [varchar](255) NULL,
	[vat_registration_no] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
