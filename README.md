Governmant database
--------------------

The interactive data storage and entry system allows login for an admin, organization or a user from a government/private institution and performing confidential/public operations on its part.

The users of the different institutions interact both with the database administrator and with each other. All data is saved in files so that there is no loss of information in the event of a system shutdown.

     In the database, every citizen has:
- SSN (id), from which the program extracts date of birth, region of birth and gender
- A name
- Permanent address
- Penalties
- Possessions (cars, properties, etc)
- Entry/exit border registrations
- Relatives
- Companies owned
- Credit files

The system has 3 account types:
--------------------

     1) Admin (keeps all state institutions under control):
- Adds new citizens
- Has access to all the information about every citizen at any time
- Creates organizations and assigns their first user

     2) Organization:
- Unites employees in one institution
- Assigns all its users after the first one

     3) User of an organization (employee in an institution):
- Has access only to the information necessary for the specific institution
- Contributes to the state database with the records for which it is responsible

Institutions the program works with:
--------------------

     1) State-owned (Ministry of the Interior - Police):
- Issues crimes
- Seizes possessions
- Registers border crossing
- Inquires private institutions

     Has access to:
- Name
- SSN (id)
- Crimes
- Possessions
- Entry/exit border registrations
- Relatives

     2) Private (Credit institution - A bank):
- Issues credits
- Seizes possessions
- Changes the account balance
- Inquires state-owned institutions

     Has access to:
- Name
- SSN (id)
- Companies owned
- Credit files of relatives
- Credit files

     Each bank has its own database, which contains:
- Account balance
- Current debt
- Address
- Phone number
- Email
