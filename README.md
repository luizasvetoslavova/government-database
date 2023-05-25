Government database
--------------------

Console app with an interactive data storage and entry system that allows login for an admin, organization or a user from a government/private institution and performs confidential/public operations on its part.

Users, or employees of different institutions interact both with the database administrator and with each other. All data is being saved in detached files so that there is no loss of information in case of a system shutdown.

In the database, every citizen has:
- SSN (id), from which the program extracts date of birth, region of birth and gender
- A name
- Permanent address
- Penalties
- Possessions (cars, estates etc)
- Entry/exit border registrations
- Relatives
- Companies owned
- Credit file

3 account types in the system:
---

     Admin (keeps all the state institutions under control):
- Adds new citizens
- Has access to all information about every citizen at any time
- Creates organizations and assigns their first user

---
     Organization:
- Unites employees in one institution
- Assigns all its users after the first one

---
     User of an organization (employee in an institution):
- Has access only to the information necessary for the specific institution
- Contributes to the state database with the records for which it is responsible

Institutions the program works with:
---

     State-owned (Ministry of the Interior - Police):
- Issues crimes
- Seizes possessions
- Registers border crossing
- Inquires private institutions

     **Has access to:**
- Name
- SSN (id)
- Crimes
- Possessions
- Entry/exit border registrations
- Relatives

---
     Private (Credit institution - A bank):
- Issues credits
- Seizes possessions
- Changes the account balance
- Inquires state-owned institutions

     **Has access to:**
- Name
- SSN (id)
- Companies owned
- Credit files of relatives
- Credit files

     **Each bank has its own database, which contains:**
- Account balance
- Current debt
- Address
- Phone number
- Email

The objective of the program is to faciliate data storage and management by the government, and unite the larger institutions on order to provide an easier experience with the internal order of a state.  
