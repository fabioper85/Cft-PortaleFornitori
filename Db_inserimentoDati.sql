USE [DB_FORNITORI]
GO

INSERT INTO [dbo].[vw_body_rental_vendor]
           ([company]
           ,[company_name_no]
           ,[name]
           ,[vat_registration_no]
		   ,[blocked_qualification])
     VALUES
           ('Consoft SpA', 'F00922', 'COMMITWORLD S.R.L.', '07574880014', 0)
		   ,('Consoft SpA', 'F00969', 'XENIALAB S.r.l.', '09668910012', 1)
GO

-- TRUNCATE TABLE [dbo].[vw_body_rental_vendor]

